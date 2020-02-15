#include <stdio.h>

int getIdx(unsigned int *arr, int len, unsigned int key) {
    int i = 0;
    for (i = 0; i < len; i++) {
        printf("-->%d ", *(arr + i));
        if (*(arr + i) == key) {
            return i;
        }
    }
    return -1;
}

int main() {
    unsigned int arr[] = {1, 2, 3, 4, 5, 6};
    int idx = getIdx(arr, sizeof (arr) / sizeof (arr[0]), 4);
    printf("idx:%d\n", idx);
    return 0;
}
