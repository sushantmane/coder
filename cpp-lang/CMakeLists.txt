cmake_minimum_required(VERSION 3.14)
project(cpp_lang)

set(CMAKE_CXX_STANDARD 17)

add_executable(cpp_lang data-structures/LinkedList.cpp data-structures/LinkedList.h data-structures/LinkedListDemo.cpp)