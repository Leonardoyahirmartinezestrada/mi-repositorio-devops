import boto3

session=boto3.Session(
    aws_access_key_id="ASIAYV3YCSLQ2EP5SDJ7",
    aws_secret_access_key="92EXuU/C22DI//Wre03m/Umqay89eK6CJbo/ZNP7",
    aws_session_token="IQoJb3JpZ2luX2VjEG4aCXVzLXdlc3QtMiJGMEQCICOU2k3+XfNSFRzvNR4ISPnas6YrjE2MEnF7deVJwhidAiBdACCYUWIwQVgY1UmFWixYSVQdhGLDgEWC+WcatbrIDyrCAgjn//////////8BEAAaDDU5NjcxNTQxMDE0NSIMR9i2h1fikY3uRS+7KpYC0yTKrxE7dobNzxZTvq9+QfFKCddoNMIKh5rT4isJ89SwdloZRbyhjVoxYFxekVhL+Nu63/8Op/t42kHqpJEF/s13A+Yn3JjRhQMOyUzZX2MZ2hgO+hz0rOA7/MNpDi+g/Xzd542pJwjhjZ0u/6KSn6D//mI9IBRQ76RzN8baOQ474u9kYx792GCcekLL3jtLVHQ97GDRDS0DErHzMN7ho7zNOu0GbtprecliDjQ9sZw5MNOLA4hefQ1p8xoyFftR7vuIo5Jo/paWTu1bgNhdtk5pcx9D2NUyx92Z/nKzYOHygUfN2F1q9r7T8stxmIbsKOyq1SU5zkDwhK6buUKR17bE2rgkBdKnRQVYpAqyxkQx7Z5Z6f0wi5ftvwY6ngEbVbQ/32Htjn8UPokg2y+FjOCL0HrWAQSCBeIB3sLtrw17R9n8aclO8G8pG3Fq79AY0BoagrH6QvS8VSou/j1D02sm6xW+Vilewv0azPOhNR9PicDhS8tCc7HuaSZ4Mp04L4WZJSYiLGjXGDOnRmuOs7IfYO326ZHbeenIU+DGC04VoGf1KHrfPinJ5SAARowzJbTFQw62/wNEn/KNCg==",
    region_name="us-east-1"
)

ec2 = boto3.client('ec2', region_name='us-east-1')

def listar_instancias():
    response = ec2.describe_instances()
    for reservation in response['Reservations']:
        for instance in reservation['Instances']:
            print(f"ID: {instance['InstanceId']}, Estado: {instance['State']['Name']}, Tipo: {instance['InstanceType']}")

def gestionar_instancia(instance_id, action):
    if action == 'iniciar':
        ec2.start_instances(InstanceIds=[instance_id])
        print(f"Instancia {instance_id} iniciada.")
    elif action == 'detener':
        ec2.stop_instances(InstanceIds=[instance_id])
        print(f"Instancia {instance_id} detenida.")

if __name__ == "__main__":
    listar_instancias()
    gestionar_instancia('i-09b87ac7d636efc66', 'detener')