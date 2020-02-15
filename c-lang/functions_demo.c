#include <stdio.h>
#include <stdlib.h>

struct node {
        int data;
        struct node *next;
};

typedef struct node node_t;

void add_node(node_t **root, int data) {
        node_t *new_node = malloc(sizeof(node_t));
        new_node->data = data;
        printf("%d - %p\n", data, new_node);
        if (new_node == NULL) {
            fprintf(stderr, "Failed to allocate memory\n");
            exit(1);
        }
        if (*root == NULL) {
            *root = new_node;
            new_node->next = NULL;
            return;
        }
        new_node->next = *root;
        *root = new_node;
}

void print_list(node_t *root) {
    if (root == NULL) {
        return;
    }
    printf("%d ", root->data);
    print_list(root->next);
}

int main() {
        node_t *root = NULL;
        int arr[] = {10, 11, 12, 13, 14, 15, 16};
        int arr_len = sizeof arr / sizeof arr[0];
        for (int i = 0; i < arr_len; i++) {
            add_node(&root, arr[i]);
        }
        print_list(root);
        printf("\n%p\n", &root);
        printf("\n%p\n", &*root);
        return 0;
}
