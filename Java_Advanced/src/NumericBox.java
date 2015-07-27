import java.io.Serializable;


	public	class	NumericBox<T	extends	Object	&	Serializable	&	Cloneable>	{
		private	T	object;
		public	void	set(T	object)	{	this.object	=	object;	}
		public	T	get()	{	return	object;	}
		public	static	void	main(String[]	args)	{

						NumericBox rawBox = new NumericBox();
						rawBox.set(1);
						//	Compilation	error,	Incompatible	type
						rawBox.set(2.0);
		}
}
