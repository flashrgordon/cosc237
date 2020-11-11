/******************************************************
COSC 237.001                              Assignment #2
Names:         Victoria Raulin, Ryan Gordon, Ayoob Redi
Due Date:                                    10/20/2020
Program Name:                                    Matrix
 ******************************************************/

import java.util.Random;

public class Matrix {
	public final int MAX = 20;

	private int size;
	private int[][] table;

	public Matrix() {
		size=0;
	}
	public Matrix(int size) {
		this.size = size;
		table = new int[size][size];
	}

	//GETTERS
	public int getSize() {
		return size;
	}
	public int getElement(int r, int c) {
		return table[r][c];
	}

	//SETTERS
	public void setElement(int r, int c, int value) {
		this.table[r][c] = value;
	}

	//OTHER METHODS
	public void init() {
		Random rand = new Random();
		for (int rows = 0; rows < this.size; rows++) {
			for (int cols = 0; cols < this.size; cols++) {
				this.table[rows][cols] = rand.nextInt(MAX + 1);
			}
		}
	}
	public boolean equals(Matrix m) {
		for (int rows = 0; rows < size; rows++) {
			for (int cols = 0; cols < size; cols++) {
				if (table[rows][cols] != m.table[rows][cols]) {
					return false;
				}
			}
		}
		return true;
	}
	public void copy(Matrix m) {
		for (int rows = 0; rows < size; rows++) {
			for (int cols = 0; cols < size; cols++) {
				table[rows][cols] = m.table[rows][cols];
			}
		}
	}
	public Matrix getCopy() {
		Matrix copy = new Matrix(size);
		for (int rows = 0; rows < size;rows++) {
			for (int cols = 0; cols < size; cols++) {
				copy.table[rows][cols] = table[rows][cols];
			}
		}
		return copy;
	}
	public void print() {
		for (int r = 0; r < table.length; r++) {
			for (int c = 0;c < table[r].length;c++) {
				System.out.printf("%5d",table[r][c]);
			}
			System.out.println();
		}
	}
	public Matrix add(Matrix a) {
		Matrix sum = new Matrix(size);
		for (int r = 0; r < table.length; r++) {
			for (int c = 0; c < table[r].length; c++) {
				sum.table[r][c] = table[r][c]  +a.getElement(r,c);
			}
		}
		return sum;
	}
	public Matrix subtract(Matrix a) {
		Matrix diff = new Matrix(size);
		for (int r = 0; r < table.length; r++) {
			for (int c = 0; c < table[r].length;c++) {
				diff.table[r][c] = table[r][c] - a.getElement(r,c);
			}
		}
		return diff;
	}

	public Matrix multiplyMatrix(Matrix m) {
		Matrix product = new Matrix(size);
		for (int rows = 0; rows < size; rows++) {
			for (int cols = 0; cols < size; cols++) {
				for (int k = 0; k < size; k++) {
					product.table[rows][cols] += table[rows][k] * m.table[k][cols];
				}
			}
		}
		return product;
	}

	public void multiplyConstant(int constant) {
		for (int rows = 0; rows < table.length; rows++) {
			for (int cols = 0; cols < table[rows].length; cols++) {
				table[rows][cols] *= constant;
			}
		}
	}


	public Matrix transposeMatrix(){
		Matrix result = new Matrix(size);
		for (int rows = 0; rows < size; rows++) {
			for (int cols = 0; cols < size; cols++) {
				result.table[rows][cols] = this.table[cols][rows];
			}
		}
		return result;
	}

	public int traceMatrix(){
		int result = 0;
		for (int i = 0; i < size;i++) {
			result += table[i][i];
		}
		return result;
	}
}
