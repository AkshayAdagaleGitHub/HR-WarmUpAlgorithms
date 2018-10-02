import java.util.List;

class Account{
    int balance =0;
    
    public Account(int balance) {
		super();
		this.balance = balance;
	}

	public String deposit(int money){
        return ("Depositing $"+ money);
    }
    
     public String withdraw(int money){
           if(money>balance || money <0) {
                 return ("Withdrawing $"+ money +"(Insufficient Balance)");
             }else if(balance > money) {
               int bal = balance-money;
                 return ("Withdrawing $"+ money);
             }
             return ("Withdrawing $"+ money);                
         }
    
    public int getBalance() {
            return balance;
        }
}
class Transaction{
    Account account;
    List<String> transactions;
    
     public Transaction(Account account, List<String> transactions) {
		super();
		this.account = account;
		this.transactions = transactions;
	}
	void deposit(int money){
        account.deposit(money);
    }
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<String> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}

}
public class Binary_tree {

	class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data =data;
			left=right=null;
		}
		int balance=0;

		 public String deposit(int money){
		        return ("Depositing $"+ money);
		    }
		    
		 public String withdraw(int money){
			 if(money>balance || money <0) {
				 return ("Withdrawing $"+ money +"(Insufficient Balance)");
			 }else if(balance > money) {
				 return ("Withdrawing $"+ money);
			 }
			 return ("Withdrawing $"+ money);		        
		 }
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
	}
	
	Node root;
	
	Binary_tree(){
	root=null;
	}
	
	int search(Node root,int data) {
		Node current = root;
		String present="Not found";
		while(current.data != data) {
			if(current!=null) {
				
				if(data>current.data) {
					current=current.right;
					present="left";
				}else {
						current=current.left;
						present="right";
				}
				if(current == null) {
					return 0;
				}
			}
		}
		if(current.data== data) {
			System.out.println(current.data);
			System.out.println("Present At :"+ present);
		}
		int item = current.data;
		return item;
	}
	
	void insert(int key) {
		root=InsertRecursive(root,key);
	}
	
	Node InsertRecursive(Node root,int data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(data <= root.data) {
			System.out.println(data +" Left ");
			root.left=InsertRecursive(root.left,data);
		}else if(data > root.data) {
			System.out.println(data +" Right ");
			root.right=InsertRecursive(root.right,data);
		}
		return root;
	}
	
	
	void inorder() {
		inorderRecurse(root);
	}
	
	void inorderRecurse(Node root) {
		if(root != null) {
			inorderRecurse(root.left);
			System.out.println(root.data);
			inorderRecurse(root.right);
		}
	}
	
	public static void main(String args[]) {
		Binary_tree tree= new Binary_tree();
		//4 2 5 1 3 7 6 8
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(6);
		tree.insert(8);
		/*
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        */ tree.inorder();
         int item = tree.search(tree.root, 8);
         System.out.println("The item is : "+ item);
         int height = tree.height(tree.root);
         System.out.println("Height is : "+ height );
         tree.deleteNode(8);
         tree.inorder();
         height = tree.height(tree.root);
         System.out.println("Height is : "+ height );
         
	}

	private void deleteNode(int i) {
		root=delete(root,i);		
	}

	private int height(Node root) {
		int lHeight=1;
		int rHeight=1;
		Node lheight=root;
		Node rheight=root;
		if(root==null) {
			return 0;
		}
		while(lheight.left!=null) {
				lHeight++;
				lheight = lheight.left;
			}
		while(rheight.right!=null) {
			rHeight++;
			rheight=rheight.right;
		}
		System.out.println("Left height is :" + lHeight);
		System.out.println("Right height is :" + rHeight);
		if(lHeight>rHeight) {
			return lHeight;
		}else {
			return rHeight;
		}
	}
	
	Node delete(Node root,int data) {
		if(root==null) {
			return root;
		}
		if(data < root.data) {
			root.left = delete(root.left,data);
		}else if (data > root.data) {
			root.right = delete(root.right,data);
		}
		else {
			if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
					return root.left;
				}
		
		root.data = minValue(root.right);
		root.right=delete(root.right,root.data);
	}
		return root;
	}

	private int minValue(Node right) {
		int min = right.data;
		while(root.left!=null) {
			min=root.left.data;
			root = root.left;
		}
		return min;
	}
}
