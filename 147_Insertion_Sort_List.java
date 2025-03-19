/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 1. 더미 노드 생성 (sorted list 관리용)
        ListNode dummy = new ListNode(0);

        // 2. 현재 정렬할 노드를 가리킬 포인터
        ListNode current = head;

        while (current != null) {
            // 3. 삽입할 위치를 찾기 위한 포인트
            ListNode prev = dummy;

            // 4. prev가 삽입할 위치를 찾을 때까지 이동
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // 5. current를 prev 다음에 삽입
            ListNode next = current.next; // 다음 탐색할 노드 저장
            current.next = prev.next;
            prev.next = current;

            // 6. 다음 노드로 이동
            current = next;
        }

        // 7. 정렬된 리스트의 head 반환
        return dummy.next;
    }
}