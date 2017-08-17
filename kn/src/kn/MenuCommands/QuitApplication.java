package kn.MenuCommands;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class QuitApplication implements ICommand
{
	@Override
	public void Execute() 
	{
		System.exit(0);
	}
}
