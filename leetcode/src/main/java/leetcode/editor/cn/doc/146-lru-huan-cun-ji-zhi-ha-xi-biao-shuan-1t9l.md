本题需要实现O(1)的插入和删除操作, 可以用哈希表 + 双向链表的操作实现

其中双向链表可以自己写, 也可以使用STL中的list

### 1 | 自己写双向链表

```cpp
struct doubleList {
    int key, value;
    doubleList* next, *prev;
    // constructor
    doubleList(): prev(nullptr), next(nullptr){};
    doubleList(int k, int v): key(k), value(v), prev(nullptr), next(nullptr){};
};

class LRUCache {
private:
    int sz;
    int cap = 0;
    unordered_map<int, doubleList*> cache;
    // 虚拟头结点和虚拟尾结点
    doubleList *dummyHead, *dummyTail; 

public:
    LRUCache(int capacity): sz(capacity) {
        dummyHead = new doubleList();
        dummyTail = new doubleList();
        dummyHead->next = dummyTail;
        dummyTail->prev = dummyHead;
    }
    
    int get(int key) {
        int ans;
        if (cache.count(key)) {
            ans = cache[key]->value;
            moveToHead(cache[key]);
        } else {
            ans = -1;
        }
        return ans;
    }
    
    void put(int key, int value) {
        if (cache.count(key)) {
            cache[key]->value = value;
            moveToHead(cache[key]);
        } else {
            ++cap;
            if (cap > sz) {
                --cap;
                removeTail();
            } 
            doubleList* newNode = new doubleList(key, value);
            insertToHead(newNode);
            cache[key] = newNode;
        }
    }

    // 删除结点
    void removeNode(doubleList* node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }

    // 删除尾部结点
    void removeTail() {
        // cache中删除
        cache.erase(dummyTail->prev->key);
        removeNode(dummyTail->prev);
    }

    // 移动该结点到头部
    void moveToHead(doubleList* node) {
        removeNode(node);
        insertToHead(node);
    }

    // 头插结点
    void insertToHead(doubleList* node) {
        dummyHead->next->prev = node;
        node->next = dummyHead->next;
        dummyHead->next = node;
        node->prev = dummyHead;
    } 
};
```

### 2 | 利用STL的list

这里主要需要好好理解list的`splice`这个方法

`void splice (iterator position, list& x, iterator i);`

简单来说就是把`x`这个`list`的`i`处元素插入到`position`的位置

```cpp
class LRUCache {
    list<pair<int, int>> cache;
    unordered_map<int, list<pair<int, int>>::iterator> hash;
    int size;
public:
    LRUCache(int capacity):size(capacity) {}
    
    int get(int key) {
        auto it = hash.find(key);
        if (it == hash.end()) {
            return -1;
        } else {    
            cache.splice(cache.begin(), cache, it->second);
            return it->second->second;
        }
    }
    
    void put(int key, int value) {
        auto it = hash.find(key);
        if (it != hash.end()) {
            it->second->second = value;
            cache.splice(cache.begin(), cache, it->second);
            return;
        } else {
            cache.insert(cache.begin(), make_pair(key, value));
            hash[key] = cache.begin();
            if (cache.size() > size) {
                hash.erase(cache.back().first);
                cache.pop_back();
            }
        }
    }
};
```