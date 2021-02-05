using UnityEngine;


public class PlatformManager : MonoBehaviour
{
    public PlatformEffector2D effector;
    public Animator animator;


    void Update()
    {
        if (Input.GetKey("s"))
        {
            effector.rotationalOffset = 180f;
        }


        if (Input.GetKey("w"))
        {
            effector.rotationalOffset = 0f;
        }
    }


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            animator.enabled = true;
        }
    }


    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            animator.enabled = false;
        }
    }

}