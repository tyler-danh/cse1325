#include <iostream>

class Item(){
    public:
        Item(std::string name, int price) : _name{name}, _price{price}{}
        std::string to_string(){
            return name << "(" << price << ")";
        }
    private:
        std::string _name;
        int _price = 0;

};