   M S B A M L   `   `   `  ����E  AFinanciero, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null'clr-namespace:Financiero
Financiero  5   	       Financiero.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   *localclr-namespace:Financiero     5   	     � Title$  
Financiero��5   	   $	��410��6   $	��481��6)    � 
ResizeMode$ NoResize=�65    � Icon$ 	/logo.png��6K   .��5	      � ��5
   
   �� 5       �� ImageSource$ 
/Fondo.png��6   .+�5   
   �� $��BANCO��6   $
��Left=�6    $��	31,28,0,0q�6;   $	��Top=�6N   �� 5   
   -   5         ��Name$ 
comboBanco��5      $
��Left=�6'   $��	95,30,0,0q�6B   $	��Top=�6U   $	��130��6m   .@�5      �� $��	Santander��6   �� 5      $
��BBVA��6   �� 5      $��La Caixa��6   �� 5      $��Bankia��6   �� 5      $��Sabadell��6   5      �� 5   
   $��Tarjetas crédito��6   $��
253,23,0,0q�6-   $
��Left=�6A   $	��175��6\   $	��114��6h   $	��Top=�6u   .��5      �� $��	10,0,10,0q�6   $��57��6,   .+�5      	� -   5         	�Name$ rbVisa��5      $
��VISA��6.   $��0,0,0,6q�6=    	� 	GroupName$ tipoTarjeta��6N    d� 	IsChecked$
 TrueY�6f   	� 5      -   5        $ rbMaster��5      $��
Mastercard��60   $��0,0,0,6q�6E   $ tipoTarjeta��6V   	� 5      -   5        $ 
rbAmerican��5      $��American Express��62   $��0,0,0,6q�6M   $ tipoTarjeta��6^   5      5      �� 5   
   $��Cuenta Corriente��6   $
��Left=�6+   $��
31,173,0,0q�6F   $	��Top=�6Z   �� 5   
   -   5         ��Name$ 	ccEntidad��5      $
��Left=�6%   $��142,177,0,0q�6@   	 �� TextWrapping$
	 Wrap=�6U   $	��Top=�6i   $��60��6�   ${�False��6�   �� 5   
   -   5        $ 
ccSucursal��5      
 �� 	MaxLength$
 4��6&   $
��Left=�64   $��207,177,0,0q�6O   $
	 Wrap=�6d   $	��Top=�6x   $��45��6�   �� 5   
   -   5        $
 ccDc��5      $
��Left=�6    $��257,177,0,0q�6;   $
	 Wrap=�6P   $	��Top=�6d   $��35��6|   ${�False��6�   �� 5    
   -   5        $ ccCuenta��5       $
 10��6$   $
��Left=�63   $��297,177,0,0q�6N   $
	 Wrap=�6c   $	��Top=�6w   $	��131��6�   �� 5!   
   $��Entidad��6   $
��Left=�6"   $��138,154,0,0q�6=   $	��Top=�6R   $��10(�6j   �� 5"   
   $��Sucursal��6   $
��Left=�6#   $��204,154,0,0q�6>   $	��Top=�6S   $��10(�6k   �� 5#   
   $��DC��6   $
��Left=�6   $��253,154,0,0q�68   $	��Top=�6M   $��10(�6e   �� 5$   
   $��Cuenta��6   $
��Left=�6!   $��294,154,0,0q�6<   $	��Top=�6Q   $��10(�6i   �� 5%   
   $��Cuenta IBAN��6   $
��Left=�6&   $��
31,206,0,0q�6A   $	��Top=�6U   �� 5&   
   -	   5        $ ciIban��5&      $
��Left=�6"   $��142,210,0,0q�6=   $
	 Wrap=�6R   $	��Top=�6f   $��60��6~   ${�False��6�   �� 5'   
   -
   5        $ ciCuenta��5'      $
��Left=�6$   $��207,210,0,0q�6?   $
	 Wrap=�6T   $	��Top=�6h   $	��221��6�   ${�False��6�   �� 5(   
   -   5        $ 
numTarjeta��5(      $
��Left=�6&   $��142,267,0,0q�6A   $
	 Wrap=�6V   $	��Top=�6j   $	��286��6�   ${�False��6�   �� 5)   
   $��Número tarjeta pago��6   $
��Left=�6.   $��138,244,0,0q�6I   $	��Top=�6^   $��10(�6v   �� 5*   
   -   5         ��Name$ 
btnGenerar��5*      $��GENERAR��6%   $
��Left=�67   $��306,310,0,0q�6R   $	��Top=�6g   $��36��6   $	��122��6�   $��20(�6�   ���	#FF6092AD
�������$��Calibri)�6�   ��6�   Z� �� 5+   
   $
��Left=�6   $��59��6+   $��
36,245,0,0q�67   $	��Top=�6K   $��82��6c   $��/tarjetas.png��6n   5,      5-      