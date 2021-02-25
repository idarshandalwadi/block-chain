package block_chain;

import java.sql.Timestamp;

/**
 * Purpose to test a created block-chain demo.
 * 
 * @author darshan.dalwadi
 *
 */
public class Driver {

	public static void main(String[] args) {

		BlockChain myChain = new BlockChain();

		myChain.addBlock(new Block("0x2021", new Timestamp(System.currentTimeMillis()), "Block-1 data.!"));
		myChain.addBlock(new Block("0x2022", new Timestamp(System.currentTimeMillis()), "Block-2 data.!"));
		myChain.addBlock(new Block("0x2023", new Timestamp(System.currentTimeMillis()), "Block-3 data.!"));
		myChain.addBlock(new Block("0x2024", new Timestamp(System.currentTimeMillis()), "Block-4 data.!"));
		myChain.addBlock(new Block("0x2025", new Timestamp(System.currentTimeMillis()), "Block-5 data.!"));

		myChain.viewChain(); // Check the output

	}

}
