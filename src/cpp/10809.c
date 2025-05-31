#include <stdio.h>

int main(void) {
    int alpha[26];
    for(int i=0; i<26; i++) {
        alpha[i]=-1;
    }
    char word[100]={'\0',};
    scanf("%s", &word);
    for(int i=0; i<100; i++) {
        if(alpha[word[i]-97]!=-1) continue;
        alpha[word[i]-97] = i;
    }
    for(int i=0; i<26; i++) {
        printf("%d ", alpha[i]);
    }
}