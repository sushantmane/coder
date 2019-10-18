#include <stdio.h>
#include <stdlib.h>

#define ARRAY_LEN(array) (sizeof array / sizeof array[0])

struct node {
	int data;
	struct node *next;
};

typedef struct node node_t;


node_t* get_new_node(int data)
{
	node_t *new = malloc(sizeof(node_t));
	new->data = data;
	new->next = NULL;

	return new;
}

void add_at_end(node_t **head_ref, int data)
{
	node_t *current = *head_ref;
	node_t *new = get_new_node(data);

	if (*head_ref == NULL) {
		*head_ref = new;
		return;
	}

	while (current->next != NULL) {
		current = current->next;
	}
	current->next = new;
}

void print_list(node_t *runner)
{
	while(runner != NULL) {
		printf("%d ", runner->data);
		runner = runner->next;
	}
	printf("\n");
}

void copy_list_iterative(node_t **dest_head_ref, node_t *src_head)
{
	node_t *src_runner = src_head;
	node_t *prev;
	node_t *new;

	if (src_head == NULL) {
		return;
	}

	while (src_runner != NULL) {
		new = get_new_node(src_runner->data);
		if (*dest_head_ref == NULL) {
			*dest_head_ref = new;
		} else {
			prev->next = new;
		}
		prev = new;
		src_runner = src_runner->next;
	}
}

void copy_list_recursive(node_t **dest_node_ref, node_t *src_node)
{
	node_t *new;
	
	if (src_node == NULL) {
		return;
	}
	
	new = get_new_node(src_node->data);
	*dest_node_ref = new;
	copy_list_recursive(&(new->next), src_node->next);
}

int main()
{
	node_t *src_head = NULL;
	node_t *dest_head = NULL;
	node_t *r_dest_head = NULL;
	int nums[] = {1, 2, 3, 4, 5, 6, 7};
	int i;

	for (i = 0; i < ARRAY_LEN(nums); i++) {
		add_at_end(&src_head, nums[i]);
	}
	print_list(src_head);

	copy_list_iterative(&dest_head, src_head);
	print_list(dest_head);
	copy_list_recursive(&r_dest_head, src_head);
	print_list(dest_head);

	return 0;
}
