//UIUC CS125 FALL 2013 MP. File: hello.cpp, CS125 Project: FunWithCPP, Version: 2013-11-19T00:19:16-0600.512503610
#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int main()
{
   cout << "Hey,";
   string mesg = "this my first C++ program";
   mesg += "!";
   cout << mesg << endl;
 
  // endl stands for 'end line'

   for(int i=0; i<10; i++) {
     cout << i*i;
     cout << endl;
   }
   return 0;
}
