package hash;
/**
 * @des 自定义简单的HashMap
 */

import java.util.LinkedList;

public class HashMap {

    // 数组
    private LinkedList[] arr = null;
    // 大小
    int size;

    //初始化
    public HashMap() {
        this.arr = new LinkedList[10];
    }

    /**
     * 获取大小的方法
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * map的添加方法
     *
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {

        // key 放在 那个具体的链表上
        int index = key.hashCode() % arr.length;

        // 取出链表
        LinkedList list = arr[index];

        // 创建 entry
        Entry entry = new Entry(key, value);

        if (list == null) { // 第一次添加 没有 链表 创建链表
            list = new LinkedList();
            list.add(entry);
            arr[index] = list;

        } else {
            list.add(entry);
        }
        size++;
    }

    /**
     * 通过key 获取value的值
     * @param key
     * @return
     */
    public Object getValue(Object key) {
        // 1 获取对应的链表
        // key 放在 那个具体的链表上
        int index = key.hashCode() % arr.length;

        // 取出链表
        LinkedList list = arr[index];
        // 2遍历链表 找到entry (key判断 找entry)
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                // 拿到entry
                Entry entry = (Entry) list.get(i);
                if (entry != null) {
                    // 判断是我要找的 entry
                    if (entry.key.equals(key)) {
                        return entry.value;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 是否包含 key
     * @param key
     * @return
     */
    public boolean containsKey(Object key) {
        // 1 获取对应的链表
        // key 放在 那个具体的链表上
        int index = key.hashCode() % arr.length;
        // 取出链表
        LinkedList list = arr[index];
        // 2 便利链表 找到entry (key判断 找entry)
        if (list != null) {

            for (int i = 0; i < list.size(); i++) {
                // 拿到entry
                Entry entry = (Entry) list.get(i);
                if (entry != null) {
                    // 判断是我要找的 entry
                    if (entry.key.equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 是否包含 key
     * @param key
     * @return
     */
    public void remove(Object key) {
        // 1 获取对应的链表
        // key 放在 那个具体的链表上
        int index = key.hashCode() % arr.length;

        // 取出链表
        LinkedList list = arr[index];
        // 2 便利链表 找到entry (key判断 找entry)

        if (list != null) {

            for (int i = 0; i < list.size(); i++) {
                // 拿到entry
                Entry entry = (Entry) list.get(i);
                if (entry != null) {
                    // 判断是我要找的 entry
                    if (entry.key.equals(key)) {
                        list.remove(entry);
                        break;
                    }
                }
            }
        }
        size--;
    }

    class Entry {

        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

}


