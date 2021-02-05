using System.Collections;
using UnityEngine;

public class FireRangeController : MonoBehaviour
{
public GameObject fireTrap;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.transform.CompareTag("Player"))
        {
            fireTrap.GetComponent<FireController>().canHit = true;
            fireTrap.GetComponent<FireController>().animator.SetBool("Pressed", true);
        }
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        if(collision.transform.CompareTag("Player"))
        {
            fireTrap.GetComponent<FireController>().canHit = false;
            fireTrap.GetComponent<FireController>().animator.SetBool("Pressed", false);
        }
    }
}
