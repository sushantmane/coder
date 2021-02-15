#include <stdio.h>

int main(int argc, char** argv) 
{
    printf("Hello, World!\n");
    char str[16];
    str[0] = 'S';
    str[1] = 'A';
    str[2] = 'N';
    str[12] = 'N';
    str[13] = '\0';

    printf("%s\n", str);
}
