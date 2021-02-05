using System.Collections;
using UnityEngine;

public class MushroomController : MonoBehaviour
{
    public Animator animator;
    Vector2 actualPosition;


    void Update()
    {
        StartCoroutine(checkMovement());
    }


    IEnumerator checkMovement()
    {
        actualPosition = transform.position;
        yield return new WaitForSeconds(0.3f);

        if(transform.position.x != actualPosition.x)
        {
            animator.SetBool("Running", true);
        }   
            else
            {
                animator.SetBool("Running", false);
            }
    }

}