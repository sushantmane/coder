package edu.sjsu.cs.cs255.revision;

public class AvlTree {

    class AvltNode {

        int val;
        int bf;
        int height;

        AvltNode left;
        AvltNode right;
        AvltNode parent;

        public AvltNode(int v) {
            val = v;
        }
    }

    AvltNode root;
    int numNodes = 0;

    int height() {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    AvltNode insert(AvltNode node, AvltNode newNode, AvltNode parent) {
        if (node == null) {
            newNode.parent = parent;
            return newNode;
        }

        if (newNode.val < node.val) {
            node.left = insert(node.left, newNode, node);
        } else {
            node.right = insert(node.right, newNode, node);
        }
        update(node);
        return balance(node);
    }

    AvltNode balance(AvltNode node) {
        if (node.bf <= -2) {
            if (node.left.bf <= 0) {
                return rightRotate(node);
            } else {
                return leftRightRotate(node);
            }
        } else if (node.bf >= 2) {
            if (node.right.bf >= 0) {
                return leftRotate(node);
            } else {
                return rightLeftRotate(node);
            }
        }
        return node;
    }

    AvltNode leftRotate(AvltNode node) {
        AvltNode newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;

//        if (node.parent != null) {
//            if (node.parent.left == node) {
//                node.parent.left = newParent;
//            } else {
//                node.parent.right = newParent;
//            }
//        }

        newParent.parent = node.parent;
        node.parent = newParent;
        if (node.right != null) {
            node.right.parent = node;
        }
        update(node);
        update(newParent);
        return newParent;
    }

    AvltNode rightRotate(AvltNode node) {
        AvltNode newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;

//        if (node.parent != null) {
//            if (node.parent.left == node) {
//                node.parent.left = newParent;
//            } else {
//                node.parent.right = newParent;
//            }
//        }

        newParent.parent = node.parent;
        node.parent = newParent;
        if (node.left != null) {
            node.left.parent = node;
        }
        update(node);
        update(newParent);
        return newParent;
    }

    AvltNode leftRightRotate(AvltNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    AvltNode rightLeftRotate(AvltNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    void update(AvltNode node) {
        int leftHt = node.left == null ? -1 : node.left.height;
        int rightHt = node.right == null ? -1 : node.right.height;

        node.height = Math.max(leftHt, rightHt) + 1;
        node.bf = rightHt - leftHt;
    }

    boolean insert(int val) {
        if (contains(val)) {
            return false;
        }

        AvltNode newNode = new AvltNode(val);
        root = insert(root, newNode, null);
        numNodes++;
        return true;
    }


    void preOrder(AvltNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + " (bf:" + node.bf + " ht:" + node.height
                + " p:" + ((node.parent == null) ? -1 : node.parent.val) + ")");
        preOrder(node.left);
        preOrder(node.right);
    }

    void print() {
        System.out.println("Preorder trav...");
        preOrder(root);
    }

    boolean contains(AvltNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val > val) {
            return contains(node.left, val);
        } else if (node.val < val){
            return contains(node.right, val);
        }
        return true;
    }

    boolean contains(int val) {
        return contains(root, val);
    }

    AvltNode remove(AvltNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val > val) {
            node.left = remove(node.left, val);
        } else if (node.val < val) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int minVal = getMin(node.right);
                node.val = minVal;
                node.right = remove(node.right, minVal);
            }
        }

        update(node);
        return balance(node);
    }

    int getMin(AvltNode node) {
        if (node.left == null) {
            return node.val;
        }
        return getMin(node.left);
    }

    boolean remove(int val) {
        if (!contains(val)) {
            return false;
        }
        root = remove(root, val);
        numNodes--;
        return true;
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        int[] arr = {5, 4, 9, 3, 7, 6, 8, 15, 12, 16, 10, 11, 11};
        for (int n : arr) {
            System.out.println("inserting:" + n + " ?:" + tree.contains(n));
            tree.insert(n);
            tree.print();
        }

        int n = 5;
        System.out.println("remove: " + n);
        System.out.println(tree.remove(n));
        tree.print();
    }
}
