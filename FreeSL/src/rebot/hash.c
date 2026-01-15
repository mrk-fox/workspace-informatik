#include <stdio.h>
#include <string.h>

// DJB2 hash algorithm
unsigned long hash_string(const char *str) {
    unsigned long hash = 5381;
    int c;
    
    while ((c = *str++)) {
        hash = ((hash << 5) + hash) + c; // hash * 33 + c
    }
    
    return hash;
}

int main() {
    char input[256];
    
    printf("Enter a string to hash: ");
    
    // Read input from user
    if (fgets(input, sizeof(input), stdin) != NULL) {
        // Remove trailing newline if present
        size_t len = strlen(input);
        if (len > 0 && input[len-1] == '\n') {
            input[len-1] = '\0';
        }
        
        // Generate and display hash
        unsigned long hash = hash_string(input);
        printf("Hash value: %lu\n", hash);
        printf("Hash (hex): 0x%lx\n", hash);
    }
    
    return 0;
}