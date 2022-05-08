#include <stdio.h>
int main(int argc, char const *argv[])
{
    int input;
    printf("enter a value that you want to print on the terminal screen:");
    scanf("%d", &input);
    
    printf("%d\n", input);
    printf("%d", input);

    scanf("%d");
    return 0;
}
