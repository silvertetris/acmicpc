#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int * data;
    int capacity;
    int top;
} StackType;

void init_stack(StackType *s) {
    s->top = -1;
    s->capacity =100001;
    s-> data= (int*) malloc(s->capacity*sizeof(int));
}
void push(StackType *s, int data) {
    s->data[++(s->top)] = data;
}

void pop(StackType *s) {
    s->top--;
}

int main(void) {
    StackType s;
    init_stack(&s);
    int n;
    scanf("%d", &n);
    int arr[n];
    int able=1;
    int max=1; //처음부터 다시 스택에 넣지 않기 위해서 값을 밖에다가 저장함함
    char *operations = (char *)malloc(n * 2 * sizeof(char));
    int op_idx = 0;

    for(int i=0; i<n; i++) { //먼저 배열 저장장
        scanf("%d", &arr[i]);
    }
    for(int i=0; i<n; i++) {
        int temp = arr[i]; //stack 목록

        while(max<=temp) {//발견까지 덮음음
            push(&s, max++);
            operations[op_idx++]='+';
        }
        if(s.data[s.top]==temp) {
            pop(&s);
            operations[op_idx++]='-';
        } else {
            able=0;
            break;
        }
    }
    if(able==0) {
        printf("NO");
    } else {
        for(int i=0; i<op_idx; i++) {
            printf("%C\n", operations[i]);
        }
    }
}