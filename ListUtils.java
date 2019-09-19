import java.util.*;
import java.lang.*;

public class ListUtils
{
	public static void printList(Node head)
	{
		Node ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	public static Node SortedInsert(Node head, Node newNode)
	{
		Node dummy = new Node();
		Node current = dummy;
		dummy.next = head;
		
		while (current.next != null && current.next.data < newNode.data)
		{
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
		return dummy.next;
	}

	public static Node InsertSort(Node head)
	{
		Node result = null;
		Node current = head;
		Node next;

		while (current != null)
		{
			next = current.next;
			result = SortedInsert(result, current);
			current = next;
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] keys = {6, 3, 4, 8, 2, 9};
		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--)
		{
			head = new Node(keys[i], head);
		}
		
		head = InsertSort(head);
		printList(head);
	}
}