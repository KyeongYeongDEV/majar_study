#include<cstdio>
#include<cstdlib>

typedef int element;
typedef struct ListNode {
	element data;
	struct ListNode* link;
}ListNode;

void printList(ListNode* head) {
	ListNode* p;

	if (head == NULL) return;
	p = head->link;
	do {
		printf("%d->", p->data);
		p = p->link;
	} while (p != head);
	printf("%d->", p->data);
}

ListNode* insertFirst(ListNode* head, element data) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	node->data = data;
	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;
		head->link = node;
	}
	return head;
}
ListNode* insertLast(ListNode* head, element data) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	node->data = data;
	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;
		head->link = node;
		head = node;
	}
	return head;
}

int main(void) {
	ListNode* head = NULL;

	head = insertLast(head, 20);
	head = insertLast(head, 30);
	head = insertLast(head, 40);
	head = insertFirst(head, 10);
	printList(head);
	return 0;
}