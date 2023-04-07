#include <iostream>
#include <vector>

class Vending_Machine:public Item{
    public:
        void add(std::string name, int price){
            items.push_back(name, price);
        }
        void buy(int index){
            std::cout << "#### Buying: " << items[index] << std::endl;
        }
        std::string menu(){
            for(auto& i; items){
                std::cout << i << ") "<< items[i].to_string() << std::endl;
            }
        }
    private:
        std::vector<Item> items;
};