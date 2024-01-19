### Basic Git commands:

1. **git init:**

   - Initialize a new Git repository in the current directory.

   ```bash
   git init
   ```

2. **git clone:**

   - Clone a remote repository into a new local directory.

   ```bash
   git clone <repository_url>
   ```

3. **git add:**

   - Add changes in the working directory to the staging area.

   ```bash
   git add <file1> <file2> ...
   ```

4. **git commit:**

   - Record changes from the staging area to the repository.

   ```bash
   git commit -m "Commit message"
   ```

5. **git status:**

   - Display the status of changes as untracked, modified, or staged.

   ```bash
   git status
   ```

6. **git pull:**

   - Fetch changes from a remote repository and merge them into the current branch.

   ```bash
   git pull
   ```

7. **git push:**

   - Push local changes to a remote repository.

   ```bash
   git push <remote link> <branch_name>
   ```

8. **git branch:**

   - List, create, or delete branches.

   ```bash
   git branch
   git branch <branch_name>
   git branch -d <branch_name>
   ```

9. **git checkout:**

   - Switch branches or restore working tree files.

   ```bash
   git checkout <branch_name>
   ```

10. **git merge:**

    - Merge changes from one branch into another.

    ```bash
    git merge <branch_name>
    ```

11. **git log:**

    - Display the commit history.

    ```bash
    git log
    ```

12. **git remote:**

    - Manage remote repositories.

    ```bash
    git remote add <remote_name> <repository_url>
    ```