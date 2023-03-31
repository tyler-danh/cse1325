#include <iostream>
#include <vector>

int main(){
    std::vector <int> num{};
    int numbers;
    do{
        std::cin >> numbers;
        num.push_back(numbers);
    }while(numbers);
    std::cout << "Number of elements: " << num.size() << std::endl;
}