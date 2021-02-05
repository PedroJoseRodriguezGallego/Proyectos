using UnityEngine;


public class PlayerSkin : MonoBehaviour
{
    public Animator animator;
    public RuntimeAnimatorController[] playerController;

    void Start()
    {
        switch (PlayerPrefs.GetString("PlayerSelected"))
        {
            case "NinjaFrog":
                animator.runtimeAnimatorController = playerController[0];
                break;

            case "PinkMan":
                animator.runtimeAnimatorController = playerController[1];
                break;

            case "VirtualGuy":
                animator.runtimeAnimatorController = playerController[2];
                break;

            case "MaskDude":
                animator.runtimeAnimatorController = playerController[3];
                break;
        }
    }


    public void ChangeSkin()
    {
        switch (PlayerPrefs.GetString("PlayerSelected"))
        {
            case "NinjaFrog":
                animator.runtimeAnimatorController = playerController[0];
                break;

            case "PinkMan":
                animator.runtimeAnimatorController = playerController[1];
                break;

            case "VirtualGuy":
                animator.runtimeAnimatorController = playerController[2];
                break;

            case "MaskDude":
                animator.runtimeAnimatorController = playerController[3];
                break;
        }
    }

}