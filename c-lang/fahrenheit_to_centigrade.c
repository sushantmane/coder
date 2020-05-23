#include <stdio.h>

#define CONV_CONST (5.0 / 9.0)

int main()
{
    int i;
    for (i = 0; i <= 300; i += 20) {
        printf("%3d\t%6.1f\n", i, CONV_CONST * (i - 32));
    }
    for (i = 300; i >= 0; i -= 20) {
        printf("%3d\t%6.1f\n", i, (5 * (i - 32) / 9.0));
    }
}
