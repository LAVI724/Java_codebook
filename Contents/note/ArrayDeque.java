/ 宣告
Deque deque = new LinkedList<>();
Deque deque = new ArrayDeque<>();

// 在尾部加入元素
add(element)
addLast(element)
// 在頭部加入元素
addFirst(element)
    
// 在尾部加入元素，同時也返回一個boolean值來表示是否成功加入元素
offer(element)
// 在頭部加入元素，同時也返回一個boolean值來表示是否成功加入元素
offerFirst(element)
// 在尾部加入元素，同時也返回一個boolean值來表示是否成功加入元素
offerLast(element):

// 返回 Deque 的所有元素
iterator()
    
// 以相反的排序方式返回 Deque 的所有元素 
descendingIterator()
    
// 在頭部加入元素
push(element)
// 刪除在頭部元素，同時返回被刪除元素
pop(element)
// 刪除在頭部元素
removeFirst()
// 刪除在尾部元素
removeLast()
   
// 刪除在頭部元素，或者返回 Null 值假如是空的 Aarray
poll()
// 刪除在頭部元素，或者返回 Null 值假如是空的 Aarray
pollFirst()
// 刪除在尾部元素，或者返回 Null 值假如是空的 Aarray
pollLast():

// 搜索及返回在頭部元素，或者返回 Null 值假如是空的 Aarray
peek()
peekFirst()
// 搜索及返回在尾部元素，或者返回 Null 值假如是空的 Aarray
peekLast()