//GFG - MergeSort for Linked Lists
class LNode{
	int val;
	LNode next;
	String rep = "";
	LNode(int val){
		this.val = val;
		next = null;
	}
	public String toString(){
		return (val+"");
	}
}
class List{
	LNode head;
	public void push(int val){
		if(head == null){
			head = new LNode(val);
			return;
		}
		LNode node = new LNode(val);
		node.next = head;
		head = node;
	}
	public void push(int[] vals){
		if(vals == null) return;
		for(Integer i : vals){
			push(i);
		}
	}
	public String toString(){
		StringBuilder rep = new StringBuilder();
		LNode t = head;
		while(t != null){
			rep.append(t + " ");
			t = t.next;
		}
		return rep.toString().trim();
	}
}
public class MergeSortLinkedList {
	public static void main(String args[]){
		List list = new List();
		int[] vals = {5, 4, 2, 3, 1};
		list.push(vals);
		MergeSort(list);
		System.out.println(list);
	}
	public static void MergeSort(List list){
		list.head = MergeSort(list.head);
	}
	public static LNode MergeSort(LNode head){
		if(head == null || head.next == null) return head;
		LNode slow, fast, prev;
		slow = fast = prev = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		LNode list1 = MergeSort(head);
		LNode list2 = MergeSort(slow);
		return sortedMerge(list1, list2);
		
	}
	public static LNode sortedMerge(LNode head1, LNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		LNode result;
		if(head1.val <= head2.val){
			result = head1;
			result.next = sortedMerge(head1.next,head2);
		}
		else{
			result = head2;
			result.next = sortedMerge(head1, head2.next);
		}
		return result;
	}
}
