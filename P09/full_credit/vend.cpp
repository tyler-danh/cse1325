#include <iostream>
#include <vector>

int main(){
    Vending_machine v;
    v.add("R-301", 10.99);
    v.add("R-99", 8.99);
    v.add("Sentinel", 11.99);
    v.add("Wingman", 9.99);

    std::cout << "==========" << std::endl;
    std::cout << "APEX Vending" << std::endl;
    std::cout << "==========" << std::endl;
    vend.menu();

};