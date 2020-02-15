#include <iostream>

using namespace std;

struct student {
    int id;
    bool is_grad;
};

int count_grads(student arr[], int size) {
    int cnt = 0;
    for (int i = 0; i < size; i++) {
        if (arr[i].is_grad) {
            cnt++;
        }
    }
    return cnt;
}

int main(int argc, char** argv) {
    student studs[5];
    for (int i = 0; i < 5; i++) {
        student s;
        s.id = i;
        s.is_grad = true;
        studs[i] = s;
    }
    studs[0].is_grad = false;
    cout << "grad students:" << count_grads(studs, 5) << endl;
    return 0;
}
