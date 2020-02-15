#include <stdio.h>

int add(int a, int b) {
    return a + b;
}

int exec(int a, int b, int (*funct_ptr)(int, int)) {
    return (*funct_ptr)(a, b);
}

int main(int argc, char** argv) {
    printf("res:%d\n", exec(10, 20, &add));
}
