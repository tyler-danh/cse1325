#include <iostream>

class Item{
    public:
        Item(std::string name, int price) : _name{name}, _price{price}{
            if(_price<0) throw std::runtime_error{"Price cannot be negative"};
        }
        std::string to_string(){
            return _name + " (" + std::to_string(_price) + ")";
        }
    private:
        std::string _name;
        int _price = 0;

};