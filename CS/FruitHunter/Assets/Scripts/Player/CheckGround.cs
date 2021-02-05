using UnityEngine;

public class CheckGround : MonoBehaviour
{
    public static bool isGrounded; //Poner static para usar dentro de otro script
    public bool tocando;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.transform.CompareTag("Ground"))
        {
            isGrounded = true; // Si lo detecta bien
            tocando = true;
        }
        
    }


    private void OnTriggerExit2D(Collider2D collision)
    {
        if (collision.transform.CompareTag("Ground"))
        {
            isGrounded = false;
            tocando = false;
        }
    }

}