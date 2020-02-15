#include <iostream>

using namespace std;

struct ListNode {
    int data;
    ListNode* next;
};

void CreateList(ListNode** head) {
    int data;
    while (true) {
        cin >> data;
        if (data == -1) {
            break;
        }
        ListNode* new_node = new ListNode;
        new_node->data = data;
        new_node->next = *head;
        *head = new_node;
    }
}

void PrintList(ListNode* head) {
    for (ListNode* current = head; current != nullptr; current = current->next) {
        cout << current->data << " ";
    }
}

void PrintListReverse(ListNode* head) {
    if (head == nullptr) {
        return;
    }
    PrintListReverse(head->next);
    cout << head->data << " ";
}

int main() {
    ListNode* head = nullptr;
    CreateList(&head);
    PrintList(head);
    cout << endl;
    PrintListReverse(head);
    return 0;
}
