# bash script to help in pushing to github
git add .
commitMessage=$1
git commit -m "$commitMessage"
git push -u origin main