#include <stdio.h>
#include <stdlib.h>

#define ARR_LEN(arr) sizeof(arr) / sizeof(arr[0])

struct node {
    int data;
    struct node* next;
};

typedef struct node node_t;

void add_to_front(node_t** head, int data) {
    node_t* new_node = malloc(sizeof(node_t));
    new_node->data = data;
    if (*head == NULL) {
        new_node->next = NULL;
        *head = new_node;
        return;
    }
    new_node->next = *head;
    *head = new_node;
}

void add_to_end(node_t** head, int data) {
    node_t* new_node = malloc(sizeof(node_t));
    new_node->data = data;
    new_node->next = NULL;
    if (*head == NULL) {
        *head = new_node;
        return;
    }
    node_t* current = *head;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = new_node;
}

void print(node_t* head) {
    if (head == NULL) {
        printf("\n");
        return;
    }
    printf("%d ", head->data);
    print(head->next);
}

void reverse(node_t** head) {
    node_t* current = *head;
    node_t* prev = NULL;
    node_t* next = NULL;
    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *head = prev;
}

node_t* re(node_t* current, node_t* prev) {
    if (current->next == NULL) {
        current->next = prev;
        return current;
    }
    node_t* next = current->next;
    current->next = prev;
    return re(next, current);
}

void reverse_list(node_t** head) {
    if (*head == NULL) {
        return;
    }
    *head = re(*head, NULL);
}

int count(node_t* head, int key) {
    int cnt = 0;
    while (head != NULL) {
        if (head->data == key) {
            cnt++;
        }
        head = head->next;
    }
    return cnt;
}

int get_nth(node_t *head, int index) {
    int i = 0;
    while (head != NULL) {
        if (i == index) {
            return head->data;
        }
        i++;
        head = head->next;
    }
    return -1;
}

void delete_list(node_t** head) {
    node_t* current = *head;
    node_t* next;
    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
    *head = NULL;
}

int pop(node_t** head) {
    if (*head == NULL) {
        return -1;
    }
    int data = (*head)->data;
    node_t* current = *head;
    *head = (*head)->next;
    free(current);
    return data;
}

void insert_nth(node_t** head, int idx, int data) {
        node_t* new_node = malloc(sizeof(node_t));
        new_node->data = data;
        if (*head == NULL || idx == 0) {
            new_node->next = *head;
            *head = new_node;
            return;
        }
        int i = 0;
        node_t* current = *head;
        while (current->next != NULL) {
            if ((i + 1) == idx) {
                break;
            }
            i++;
            current = current->next;
        }
        new_node->next = current->next;
        current->next = new_node;
}

void sorted_insert(node_t** head, node_t* new_node) {
    if (*head == NULL || (*head)->data >= new_node->data) {
        new_node->next = *head;
        *head = new_node;
        return;
    }
    node_t* current = *head;
    while (current->next != NULL && current->next->data < new_node->data) {
        current = current->next;
    }
    new_node->next = current->next;
    current->next = new_node;
}

void insert_sort(node_t** head) {
        node_t* result = NULL;
        node_t* current = *head;
        node_t* next;
        while (current != NULL) {
            next = current->next;
            sorted_insert(&result, current);
            current = next;
        }
        *head = result;
}

int get_kth_to_last(node_t* root, int k) {
    node_t* leader = root;
    node_t* follower = root;
    while (leader != NULL && k > 0) {
        leader = leader->next;
        k--;
    }
    while (leader->next != NULL) {
        leader = leader->next;
        follower = follower->next;
    }

    return follower->data;
}

int main(int argc, char** argv) {
    node_t* root = NULL;
    int arr[] = {11, 12, 13, 14, 15, 11, 23, 11, 12, 11, 13};
    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
        add_to_front(&root, arr[i]);
    }
    print(root);
    printf("\n%d\n", get_kth_to_last(root, 2));
}
