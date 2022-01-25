package bjpublic.chap13;

import java.util.ArrayList;
import java.util.List;

public class Practice13_1 {
	/*
	 * 아래 조건을 만족하는 디렉토리 구조를 구현해 보세요.
	 * 
	 * 조건)
	 * 폴더 생성 및 삭제, 검색을 할 수 있습니다.
	 * 폴더는 트리의 노드 형태로 구성되며 부모 또는 자식 노드(폴더)를 가질 수 있습니다.
	 * 전체 폴더 경로 출력화 폴더의 생성 및 삭제, 단일 폴더 경로 출력을 할 수 있습니다.
	 * 
	 * 예제)
	 * 꽃/장미
	 * 꽃/민들레
	 * 
	 * 위와 같이 4개의 폴더가 생성되어 있으며 각각의 폴더는 하위 폴더를 가질 수 있습니다.
	 * '꽃' 폴더를 조회하면 '꽃','꽃/장미'와 같이 하위에 존재하는 모든 폴더를 화면에 출력합니다.
	 * 상위 폴더가 존재하는 '민들레' 폴더를 조회하면 '꽃/민들레' 경로를 화면에 출력합니다.
	 * 존재하지 않는 폴더는 "'{검색한 폴더명}'이 존재하지 않습니다."라는 문구를 제공합니다.
	 */
	private Node head = new Node("");
	
	private class Node {
		String name;
		List<Node> under;
		
		Node(String name) {
			this.name = name;
			under = new ArrayList<Practice13_1.Node>();
		}
	}
	
	public void add(String path) {
		String[]	names	= path.split("/");
		Node		temp	= head;
		
		for (int i = 0; i < names.length; i++) {
			boolean overlap = false;
			
			for (Node node : temp.under) {
				if (node.name.equals(names[i])) {
					temp = node;
					overlap = true;
					break;
				}
			}
			
			if (!overlap) {
				Node node = new Node(names[i]);
				temp.under.add(node);
				temp = node;
			}
		}
	}
	
	public void printAll() {
		printPath("", head);
	}
	
	public void printPath(String path, Node node) {
		System.out.println(path + "/" + node.name);
		
		for (Node internal : node.under) {
			if (node.name.equals("")) {
				printPath(path, internal);
			}
			else {
				printPath(path + "/" + node.name, internal);
			}
		}
	}
	
	public void delete(String path) {
		String[]	names	= path.split("/");
		Node		temp	= head;
		
		for (int i = 0; i < names.length; i++) {
			boolean overlap = false;
			
			for (Node node : temp.under) {
				if (node.name.equals(names[i])) {
					if (i == names.length - 1) {
						overlap = true;
						temp.under.remove(node);
						break;
					}
					else {
						temp = node;
						overlap = true;
						break;
					}
				}
			}
			
			if (!overlap) {
				System.out.println(String.format("'%s'이 존재하지 않습니다.", path));
				return;
			}
		}
	}
	
	public void find(String path) {
		String[]	names	= path.split("/");
		Node		temp	= head;
		
		for (int i = 0; i < names.length; i++) {
			boolean overlap = false;
			
			for (Node node : temp.under) {
				if (node.name.equals(names[i])) {
					if (i == names.length - 1) {
						overlap = true;
						System.out.println(path);
						break;
					}
					else {
						temp = node;
						overlap = true;
						break;
					}
				}
			}
			
			if (!overlap) {
				System.out.println(String.format("'%s'이 존재하지 않습니다.", path));
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Practice13_1 directory = new Practice13_1();
		
		directory.add("꽃/민들레/노랑");
		directory.add("꽃/민들레/흰색");
		directory.add("꽃/국화");
		directory.add("꽃/무궁화");
		directory.add("차/기아");
		directory.add("차/현대");
		directory.printAll();
		
		System.out.println("-------");
		directory.delete("차");
		directory.printAll();
		
		System.out.println("-------");
		directory.find("꽃/국화");
		directory.find("꽃/백합");
	}
}
