package block_chain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * <code> BlockChain </code> used to create a block-chain and contains related
 * support methods.
 * 
 * @author darshan.dalwadi
 *
 */
public class BlockChain {

	private List<Block> chain;

	public BlockChain() {
		super();
		this.chain = new ArrayList<>();
		chain.add(genesisBlock());
	}

	/**
	 * Here getter is Optional.
	 * 
	 * @return the chain
	 */
	public List<Block> getChain() {
		return chain;
	}

	/**
	 * <code> genesisBlock </code> method used to generate genesis block (first
	 * block).
	 * 
	 * @return
	 */
	private Block genesisBlock() {

		Block genesisBlock = new Block("0x2021", new Timestamp(System.currentTimeMillis()), "Transaction Data.!");
		genesisBlock.setPreviousHash(null);
		genesisBlock.computeHash();
		return genesisBlock;
	}

	/**
	 * <code> addBlock </code> method used to add new block to an existing chain.
	 * 
	 * @return
	 */
	public void addBlock(Block block) {

		block.computeHash();
		block.setPreviousHash(chain.get(chain.size() - 1).getHash());
		this.chain.add(block);
	}

	/**
	 * <code> viewChain </code> method used to display blocks of chain.
	 */
	public void viewChain() {

		chain.forEach(System.err::println);
	}

}
