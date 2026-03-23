cmake_minimum_required(VERSION 3.22.1)

project("password_checker")

add_library(password_checker SHARED
    password_checker.c)

find_library(log-lib log)

target_link_libraries(password_checker ${log-lib})
