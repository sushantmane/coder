/* Linked List Basics:
 *  - The list is built by connecting blocks of memory called nodes together
 *    by their next pointers.
 *  - The nodes are all allocated in the heap.
 *  - [head]--|-->[1]->[2]->[3]
 *     stack          heap
 *  - Pointers:
 *    head_ref - reference pointer - pointer to the head of the list
 *    head - REAL HEAD - stores address of the first node
 *    current/runner/walker - tmp pointers used to traverse the list
 */

#include <stdio.h>
#include <stdlib.h>

#define ARRAY_LEN(array) (sizeof array / sizeof array[0])

struct node {
	int data;
	struct node *next;
};

typedef struct node node_t;

int is_empty(node_t *head)
{
	if (head) {
		return 0;
	}

	return 1;
}

node_t* get_new_node(int data)
{
	node_t *new = malloc(sizeof(node_t));

	if (!new) {
		fprintf(stderr, "Failed to allocate memory to new node\n");
		exit(1);
	}

	new->data = data;
	new->next = NULL;
	return new;
}

void insert_at_front(node_t **head_ref, int data)
{
	node_t *new = get_new_node(data);

	if (is_empty(*head_ref)) {
		*head_ref = new;
		return;
	}

	new->next = *head_ref;
	*head_ref = new;
}

void insert_at_end(node_t **head_ref, int data)
{
	node_t *new = get_new_node(data);
	node_t *current = *head_ref;

	if (is_empty(*head_ref)) {
		*head_ref = new;
		return;
	}

	while (current->next != NULL) {
		current = current->next;
	}
	current->next = new;
}

void insert_at(node_t **head_ref, int data, int position)
{
	node_t *new = get_new_node(data);
	node_t *current = *head_ref;

	if (is_empty(*head_ref)) {
		*head_ref = new;
		return;
	}

	if (position == 0) {
		new->next = *head_ref;
		*head_ref = new;
		return;
	}

	while (current->next != NULL && --position > 0) {
		current = current->next;
	}

	if (current->next) {
		new->next = current->next;
		current->next = new;
		return;
	}

	current->next = new;
}

int get_length(node_t *head)
{
	node_t *current;
	int count = 0;

	for (current = head; current != NULL; current = current->next, count++);

	return count;
}

void print_list(node_t *current)
{
	while (current != NULL) {
		printf("%d ", current->data);
		current = current->next;
	}
	printf("\n");
}

void add_nodes_test(node_t **head_ref)
{
	int nums[] = {0, 1, 2, 3, 4, 5, 6, 7};
	int i;

	printf("-:%d:-\n", get_length(*head_ref));
	for (i = 0; i < ARRAY_LEN(nums); i++) {
		insert_at_front(head_ref, nums[i]);
	}
	print_list(*head_ref);
	printf("-:%d:-\n", get_length(*head_ref));

	for (i = 0; i < ARRAY_LEN(nums); i++) {
		insert_at_end(head_ref, nums[i]);
	}
	print_list(*head_ref);
	printf("-:%d:-\n", get_length(*head_ref));

	for (i = 0; i < ARRAY_LEN(nums); i++) {
		insert_at(head_ref, nums[i], 7 - i);
	}
	print_list(*head_ref);
	printf("-:%d:-\n", get_length(*head_ref));
}


int main()
{
	node_t *head;
	
	add_nodes_test(&head); // Compute and share the address of head with test function

	return 0;
}
