using UnityEngine;

public class JoystickController : MonoBehaviour
{
    #region variables
    float jumpSpeed = 3.75f;
    float doubleJumpSpeed = 3.25f;
    bool canDoubleJump;

    float horizontalMove = 0f;
    float horizontalSpeed = 2f;
    float verticalMove = 0f;

    public Rigidbody2D rb2D;
    public SpriteRenderer spriteRenderer;
    public AudioSource jumpSound;
    public Animator animator;
    public Joystick joystick;
    #endregion



    void FixedUpdate()
    {
        horizontalMove = joystick.Horizontal * horizontalSpeed;
        transform.position += new Vector3(horizontalMove, 0, 0) * Time.deltaTime;


        #region movement
        if (horizontalMove > 0)
        {
            spriteRenderer.flipX = false;
            animator.SetBool("Running", true);
            animator.SetBool("Falling", false);
        }

            else if (horizontalMove < 0)
            {
                spriteRenderer.flipX = true;
                animator.SetBool("Running", true);
                animator.SetBool("Falling", false);
            }

                else
                {
                    rb2D.velocity = new Vector2(0f, rb2D.velocity.y);
                    animator.SetBool("Running", false);
                }
        #endregion


        #region animatorConditions
        if(!CheckGround.isGrounded)
        {
            animator.SetBool("Jumping", true);
            animator.SetBool("Running", false);
        }
            else
            {
                animator.SetBool("DoubleJumping", false);
                animator.SetBool("Jumping", false);
                animator.SetBool("Falling", false);
            }


        if (rb2D.velocity.y < 0 && !animator.GetBool("Running"))
        {
            animator.SetBool("Falling", true);
        }
            else
            {
                animator.SetBool("Falling", false);
            }
        #endregion
    }



    public void Jump()
    {
        if (CheckGround.isGrounded)
        {
            canDoubleJump = true;
            jumpSound.Play();
            rb2D.velocity = new Vector2(rb2D.velocity.x, jumpSpeed);
        }
            else if (canDoubleJump)
            {
                animator.SetBool("DoubleJumping", true);
                canDoubleJump = false;
                jumpSound.Play();
                rb2D.velocity = new Vector2(rb2D.velocity.x, doubleJumpSpeed);
            }
    }

}