### 解题思路
**1.为什么Node要设计成同时有key和value?**
答：Node节点要有key是为了当双向链表cache因为容量限制放不了新节点时，那就需要在cache里淘汰一个很久未用的节点（即链首），那么这个淘汰节点的key也成了过期key,**就需要在map里也能同步删掉该过期key，防止get的时候返回了本不该存在的过期值**
```
//如果超过了双向链表cache的最大容量，要在map删除链首被淘汰节点所对应的key，以及在cache删除链首节点
            if(cache.size == cap){
                Node removeNode = cache.removeFirst();
                map.remove(removeNode.key);
            }
```
**2.为什么我们要自己设计一个双向链表而不是使用现成的比如双向链表LinkedList或者线性表ArrayList?**
答：1.用自带双向链表LinkedList做，其remove方法实际上不是O(1)，而是要从头遍历找到第一个节点，是O(n)，所以有时会超时；
2.从下图可以发现，线性表ArrayList才530ms比双向链表LinkedList1023ms少了一半左右竟然也可以AC，不过还不是O(1);
2.用自造链表DoubleList做，由于我们设计的remove方法是直接从被删除节点出发，修改其前后节点的指针，可O(1);
![图片.png](https://pic.leetcode-cn.com/1625654119-jNbcbf-%E5%9B%BE%E7%89%87.png)

### 代码

```java
class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;
    
    //加了void就变成了普通方法，构造方法不带任何返回值
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}

//一个节点为Node<Integer key,Integer val>的双向链表，末尾为最新使用的，链首为最久不用的
class DoubleList{
    //头尾虚节点
    Node head;
    Node tail;
    int size;
    
    //加了void就变成了普通方法，构造方法不带任何返回值
    // public void DoubleList(){
    //     head = new Node(0,0);
    //     tail = new Node(0,0);
    //     size = 0;
    //     head.next = tail;
    //     tail.prev = head;
    // }

    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //本题目不需要
    public void addFirst(Node x){
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        size++;

    }

    public Node removeFirst(){
        Node first = head.next;
        if(first == tail)
            return null;
        remove(first);
        return first;        
    }

    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    //本题目不需要
    public Node removeLast(){
        Node last = tail.prev;
        if(last == head)
            return null;
        remove(last);
        return last;
    }

    //本题目不需要
    public int size(){
        return size;
    }

}

//146.LRU缓存机制
class LRUCache {
    DoubleList cache;
    HashMap<Integer, Node> map;
    int cap;//cache的最大容量

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new DoubleList();//双向链表cache，末尾为最新使用的，链首为最久不用的
        map = new HashMap<>();
    }

    
    //get和put两个原则：
    //1.只要修改过key对应的值，就要重新放进map
    //2.只要查看过或修改过key对应的值,就要把key对应的node从原位置拿出来放到双向链表cache尾部代表刚刚用过
    public int get(int key) {
        if(!map.containsKey(key))   return -1;

        Node target = map.get(key);
        //2.只要查看过或修改过key对应的值就要把key对应的node从原位置拿出来放到双向链表cache尾部代表刚刚用过
        cache.remove(target);
        cache.addLast(target);

        return target.val;
    }
    
    public void put(int key, int value) {
        //如果关键字已经存在map里,修改键值对
        if(map.containsKey(key)){
            Node target = map.get(key);
            
            //1.只要修改过key对应的值，就要重新放进map
            target.val = value;
            map.put(key,target);
            cache.remove(target);
            cache.addLast(target);
        }else{//如果关键字不存在map,新增键值对

            //如果超过了双向链表cache的最大容量，要在map删除链首对应的key和cache删除链首节点
            if(cache.size == cap){
                Node removeNode = cache.removeFirst();
                map.remove(removeNode.key);
            }
            Node target = new Node(key,value);
            map.put(key,target);
            cache.addLast(target);
        }
        
    }

    
}
```