#include <stdio.h>
#include <stdlib.h>

#define ARR_LEN(arr) (sizeof(arr) / sizeof(arr[0]))
#define CHUNK_LEN 2

struct node {
	int data[CHUNK_LEN];
	struct node *next;
};
typedef struct node node_t;

struct list {
	node_t *head;
	int len;
};
typedef struct list list_t;

node_t* get_node()
{
	node_t *new = malloc(sizeof(node_t));
	new->next = NULL;
}

void add_node(list_t *list, int data)
{	
	node_t *new;
	node_t *current = list->head;
	int node_index = list->len / CHUNK_LEN;
	int offset = list->len % CHUNK_LEN;

	if (list->head == NULL) {
		new = get_node();
		current = new;
		list->head = new;
		list->len++;
		new->data[0] = data;
		return;
	}

	while (current->next != NULL && node_index > 0) {
		current = current->next;
		node_index--;
	}

	if (offset == 0) {
		new = get_node();
		current->next = new;
		current = new;
	}

	current->data[offset] = data;
	list->len++;
}

void print_list(list_t *list)
{
	node_t *current = list->head;
	int len = list->len;
	int i;

	while (len > 0) {
		for (i = 0; i < CHUNK_LEN && len > 0; i++, len--) {
			printf("%d ", current->data[i]);
		}
		current = current->next;
	}
	printf("\n");
}

int main()
{
	list_t *list = malloc(sizeof(list_t));
	list->head = NULL;
	list->len = 0;

	int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	int i;

	for (i = 0; i < ARR_LEN(nums); i++) {
		add_node(list, nums[i]);
	}
	print_list(list);

	return 0;
}
