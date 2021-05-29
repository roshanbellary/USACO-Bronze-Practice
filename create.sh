for f in *; do
	if [ -d "$f" ]; then
		cd "./$f"
		cd "./java"
		touch ".keep"
		cd ..
		cd "./c++"
		touch ".keep"
		cd ..
		cd ..
	fi
done
