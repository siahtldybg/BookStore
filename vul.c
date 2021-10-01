#include <stdio.h>
#include <string.h>

char data[] = "Hidden data here";
int main(int argc, char **argv[])
{
	printf("Hidden data is at %p\n", &data);
	char buffer[32];
	gets(buffer);
	printf(buffer);
	printf("\n");
	
	return 0;
}
