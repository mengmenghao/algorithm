/**
 * @author lmh
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * @projectName: algorithm
 * @className: 两数相加
 * @createDate: 2023/8/13 23:15
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode listNode1 = addTwoNumbers(listNode, listNode2);

        System.out.println(listNode1);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个供返回的节点head和 一个可移动的指针，用来指向存储两个数之和的位置
        ListNode head = null, tail = null;
        // 代表进位
        int carry = 0;
        // 第一和第二节点如果有一个不为空那就继续循环
        while (l1 != null || l2 != null) {
            // 如果节点不为空，代表节点值，否者为0
            int n1 = l1 != null ? l1.val : 0;
            // 如果节点不为空，代表节点值，否者为0
            int n2 = l2 != null ? l2.val : 0;
            // 计算这两个节点的和还加上了，上次计算的进位
            int sum = n1 + n2 + carry;
            // 如果head为空，代表着是第一次，需要初始化头节点和尾节点
            if (head == null) {
                // 因为节点中的值只能为个位数，那么，这里需要进行取模
                head = tail = new ListNode(sum % 10);
            } else {
                // 将当前计算出的值放在尾部
                tail.next = new ListNode(sum % 10);
                // 让尾部等于尾部的下一个节点，修改当前节点的位置，即将tail指向此次新加的节点
                tail = tail.next;
            }
            // 获取进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            // 如果最后的进位不为空，那么就在尾部把进位拼上
            tail.next = new ListNode(carry);
        }
        return head;
    }

}




class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
