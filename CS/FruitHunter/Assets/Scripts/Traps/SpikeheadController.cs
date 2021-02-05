using UnityEngine;

public class SpikeheadController : MonoBehaviour
{
    public Animator animator;


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            animator.Play("Blink");
        }
    }
}